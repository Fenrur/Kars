import { createEnv } from "@t3-oss/env-nextjs"
import { z } from "zod"

/* eslint-disable camelcase */
export const env = createEnv({
  server: {
    BACKEND_URL: z.string().optional(),
  },
  client: {
  },
  // If you're using Next.js < 13.4.4, you'll need to specify the runtimeEnv manually
  experimental__runtimeEnv: {
  },
})
