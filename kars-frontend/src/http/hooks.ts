import useSWR from "swr"
import { createApiClient as createHelloControllerClient } from "@/http/resources/HelloResource"
import useSWRMutation from "swr/mutation"
import { z } from "zod"

const BackendResponse = z.object({
  url: z.string(),
})

export function useBackendUrl() {
  const fetcher = async () =>
    fetch("/api/backend-url")
      .then((res) => res.json())
      .then((data) => BackendResponse.parse(data).url)

  const { error, data, mutate, isValidating, isLoading } = useSWR("backendUrl", fetcher, {
    refreshInterval: 0,
    revalidateOnReconnect: true,
    revalidateIfStale: true,
    revalidateOnFocus: false,
  })

  return {
    backendUrlError: error,
    backendUrlData: data,
    getBackendUrl: mutate,
    isBackendUrlValidating: isValidating,
    isBackendUrlLoading: isLoading,
  }
}

export function useGetHello() {
  const { backendUrlData, isBackendUrlLoading, backendUrlError } = useBackendUrl()

  const fetcher = () => {
    if (!backendUrlData) throw new Error("Backend URL not available")
    const apiClient = createHelloControllerClient(backendUrlData)
    return apiClient.getHello()
  }

  const { error, data, mutate, isLoading, isValidating } = useSWR(
    backendUrlData ? "getHello" : null,
    fetcher
  )

  return {
    getHelloError: error || backendUrlError,
    getHelloData: data,
    getHello: mutate,
    isGetHelloLoading: isLoading || isBackendUrlLoading,
    isGetHelloValidating: isValidating,
  }
}

export function usePostHello() {
  const { backendUrlData, isBackendUrlLoading, backendUrlError } = useBackendUrl()

  const fetcher = () => {
    if (!backendUrlData) throw new Error("Backend URL not available")
    const apiClient = createHelloControllerClient(backendUrlData)
    return apiClient.postHello(undefined)
  }

  const { trigger, data, error, isMutating } = useSWRMutation(
    backendUrlData ? "postHello" : null,
    fetcher
  )

  return {
    postHello: trigger,
    postHelloData: data,
    isPostHelloLoading: isMutating || isBackendUrlLoading,
    postHelloError: error || backendUrlError,
  }
}
