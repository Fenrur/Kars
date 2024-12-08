import { makeApi, Zodios, type ZodiosOptions } from "@zodios/core"
import { z } from "zod"

const endpoints = makeApi([
  {
    method: "get",
    path: "/hello",
    alias: "getHello",
    description: `Hello Get`,
    requestFormat: "text",
    response: z.string(),
  },
  {
    method: "put",
    path: "/hello",
    alias: "putHello",
    description: `Hello Put`,
    requestFormat: "text",
    response: z.string(),
  },
  {
    method: "post",
    path: "/hello",
    alias: "postHello",
    description: `Hello Post`,
    requestFormat: "text",
    response: z.string(),
  },
  {
    method: "delete",
    path: "/hello",
    alias: "deleteHello",
    description: `Hello Delete`,
    requestFormat: "text",
    response: z.string(),
  },
  {
    method: "patch",
    path: "/hello",
    alias: "patchHello",
    description: `Hello Patch`,
    requestFormat: "text",
    response: z.string(),
  },
])

export const HelloResourceApi = new Zodios(endpoints)

export function createApiClient(baseUrl: string, options?: ZodiosOptions) {
  return new Zodios(baseUrl, endpoints, options)
}
