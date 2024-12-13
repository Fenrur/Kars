import { env } from "@/env"
import { NextResponse } from "next/server"
import { promises as fs } from 'fs'

export const dynamic = "force-dynamic"

export async function GET() {
  const url = env.BACKEND_URL
  if (url) {
    return NextResponse.json({ url })
  }

  return NextResponse.json({ error: 'url not found contact an administrator' }, { status: 404 })
}
