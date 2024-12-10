import { env } from "@/env"
import { NextResponse } from "next/server"
import { promises as fs } from 'fs'

export const dynamic = "force-dynamic"

export async function GET() {
  const url = env.BACKEND_URL
  if (url) {
    return NextResponse.json({ url })
  }

  try {
    const url = await fs.readFile('/mnt/env/BACKEND_URL', 'utf-8')
    return NextResponse.json({ url })
  } catch (e) {
    console.error(e)
    return NextResponse.json({ error: 'url not found contact an administrator' }, { status: 404 })
  }
}
