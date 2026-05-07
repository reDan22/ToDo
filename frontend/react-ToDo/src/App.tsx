import { useState } from 'react'

import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>

        {count}
        
      </div>
      <button type='button' onClick={() => setCount(count => count +1)}>
        Press me
      </button>
    </>
  )
}

export default App
