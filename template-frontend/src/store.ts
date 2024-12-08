import { create } from "zustand"
import { createJSONStorage, persist } from "zustand/middleware/persist"

export interface HelloState {
  foo: string;
  setFoo: (by: string) => void;
  bar: number;
  setBar: (by: number) => void;
}

export const useHello = create<HelloState>()(
  persist(
    (set) => ({
      foo: "hello",
      setFoo: (by) => {
        set({ foo: by })
      },
      bar: 42,
      setBar: (by) => {
        set({ bar: by })
      },
    }),
    {
      name: "hello-storage",
      storage: createJSONStorage(() => localStorage),
    },
  ),
)
