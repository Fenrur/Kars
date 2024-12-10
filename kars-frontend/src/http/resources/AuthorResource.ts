import { makeApi, Zodios, type ZodiosOptions } from "@zodios/core"
import { z } from "zod"

const GetAuthorResponseBody = z
  .object({
    id: z.number().int(),
    firstName: z.string(),
    lastName: z.string(),
  })
  .strict()
  .passthrough()
const CreateAuthorRequestBody = z
  .object({ firstName: z.string(), lastName: z.string() })
  .strict()
  .passthrough()
const UpdateAuthorResponseBody = z
  .object({
    id: z.number().int().optional(),
    firstName: z.string(),
    lastName: z.string(),
  })
  .strict()
  .passthrough()
const UpdateAuthorRequestBody = z
  .object({ firstName: z.string(), lastName: z.string() })
  .strict()
  .passthrough()

export const schemas = {
  CreateAuthorRequestBody,
  UpdateAuthorResponseBody,
  UpdateAuthorRequestBody,
}

const endpoints = makeApi([
  {
    method: "get",
    path: "/author",
    alias: "getAuthor",
    description: `Get Authors`,
    requestFormat: "json",
    response: z.array(GetAuthorResponseBody),
  },
  {
    method: "post",
    path: "/author",
    alias: "postAuthor",
    description: `Create Author`,
    requestFormat: "json",
    parameters: [
      {
        name: "body",
        type: "Body",
        schema: CreateAuthorRequestBody,
      },
    ],
    response: z.void(),
  },
  {
    method: "put",
    path: "/author/:id",
    alias: "putAuthorId",
    description: `Update Author`,
    requestFormat: "json",
    parameters: [
      {
        name: "body",
        type: "Body",
        schema: UpdateAuthorRequestBody,
      },
      {
        name: "id",
        type: "Path",
        schema: z.number().int(),
      },
    ],
    response: UpdateAuthorResponseBody,
  },
  {
    method: "delete",
    path: "/author/:id",
    alias: "deleteAuthorId",
    description: `Delete Author`,
    requestFormat: "json",
    parameters: [
      {
        name: "id",
        type: "Path",
        schema: z.number().int(),
      },
    ],
    response: z.void(),
  },
])

export const AuthorResourceApi = new Zodios(endpoints)

export function createApiClient(baseUrl: string, options?: ZodiosOptions) {
  return new Zodios(baseUrl, endpoints, options)
}
