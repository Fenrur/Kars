import { makeApi, Zodios, type ZodiosOptions } from "@zodios/core"
import { z } from "zod"

const GetBookResponseBody = z
  .object({
    id: z.number().int(),
    title: z.string(),
    description: z.string(),
    publishedYear: z.number().int().optional(),
    authorId: z.number().int().optional(),
  })
  .strict()
  .passthrough()
const UpdateBookResponseBody = z
  .object({
    id: z.number().int().optional(),
    title: z.string(),
    description: z.string(),
    publishedYear: z.number().int().optional(),
    authorId: z.number().int().optional(),
  })
  .strict()
  .passthrough()
const UpdateBookRequestBody = z
  .object({
    id: z.number().int().optional(),
    title: z.string(),
    description: z.string(),
    publishedYear: z.number().int().optional(),
    authorId: z.number().int().optional(),
  })
  .strict()
  .passthrough()
const CreateBookResponseBody = z
  .object({
    id: z.number().int().optional(),
    title: z.string(),
    description: z.string(),
    publishedYear: z.number().int().optional(),
    authorId: z.number().int().optional(),
  })
  .strict()
  .passthrough()
const CreateBookRequestBody = z
  .object({
    title: z.string(),
    description: z.string(),
    publishedYear: z.number().int().optional(),
    authorId: z.number().int().optional(),
  })
  .strict()
  .passthrough()

export const schemas = {
  UpdateBookResponseBody,
  UpdateBookRequestBody,
  CreateBookResponseBody,
  CreateBookRequestBody,
}

const endpoints = makeApi([
  {
    method: "get",
    path: "/books",
    alias: "getBooks",
    description: `Get Books`,
    requestFormat: "json",
    response: z.array(GetBookResponseBody),
  },
  {
    method: "put",
    path: "/books",
    alias: "putBooks",
    description: `Update Book`,
    requestFormat: "json",
    parameters: [
      {
        name: "body",
        type: "Body",
        schema: UpdateBookRequestBody,
      },
    ],
    response: UpdateBookResponseBody,
  },
  {
    method: "post",
    path: "/books",
    alias: "postBooks",
    description: `Create Book`,
    requestFormat: "json",
    parameters: [
      {
        name: "body",
        type: "Body",
        schema: CreateBookRequestBody,
      },
    ],
    response: CreateBookResponseBody,
  },
  {
    method: "delete",
    path: "/books/:id",
    alias: "deleteBooksId",
    description: `Delete Book`,
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

export const BookResourceApi = new Zodios(endpoints)

export function createApiClient(baseUrl: string, options?: ZodiosOptions) {
  return new Zodios(baseUrl, endpoints, options)
}
