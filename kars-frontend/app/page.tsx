"use client"

import { useState } from "react"
import { Button } from "@/components/ui/button"
import { useGetHello, usePostHello } from "@/http/hooks"

export default function Home() {
  const [ count, setCount ] = useState(0)
  const { isGetHelloLoading, getHelloData } = useGetHello()
  const { isPostHelloLoading, postHelloData, postHello } = usePostHello()

  const handleClickPost = () => {
    void postHello()
  }

  return (
    <div className="grid w-96 justify-center gap-2">
      <h1>Counter: {count}</h1>
      <Button onClick={() => setCount(count + 1)}>Increment</Button>
      {isGetHelloLoading ? <p>Loading...</p> : <p>{getHelloData}</p>}
      <Button
        onClick={(ev) => {
          ev.preventDefault()
          handleClickPost()
        }}
      >
        Post
      </Button>
      {isPostHelloLoading ? <p>Loading...</p> : <p>{postHelloData}</p>}
    </div>
  )
}
