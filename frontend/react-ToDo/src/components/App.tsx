import { useState } from 'react'

import '../App.css'
import {Card} from './Card'
import { Age } from './Age';

const cardArr : {id:number; title:number}[] = [];

for(let i = 0 ; i < 10; i++){
  cardArr.push({id : i, title: i});
}

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      
      <Age age={1}>
        {
        cardArr.map(cardEl => {return <Card key = {cardEl.id} title={cardEl.title + count}/>}) 
        }
        
      </Age>
      
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
