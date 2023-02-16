import { useState } from 'react'
import Header from './header'
import Body from './body'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <div className='fixed bg-neutral-200 w-screen h-screen'></div>
      <Body/>
      <Header/>
    </div>
  )
}

export default App
