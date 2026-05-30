import type { ReactNode } from "react"

interface AgeProps{
    children: ReactNode,
    age: number;
}


export function Age({children, age}:AgeProps) {
    return(
    <div className={`flex ${age == 0 ? "bg-black" : "bg-red-500"}`}>
        {children}
    </div>
    )
}