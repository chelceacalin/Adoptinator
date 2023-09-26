import React,{useContext} from 'react'
import { userData } from '../../context/UserContext';
function Home() {
  const {username}=useContext(userData);
  return (
    <div>Home, {username}</div>
  )
}

export default Home