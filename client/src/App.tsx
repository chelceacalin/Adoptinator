import "./App.css";
import Login from "./components/Login/Login";
import Home from "./components/Home/Home";
import { BrowserRouter, Routes, Route } from "react-router-dom";

export default function App() {
  return (
    <BrowserRouter>
      <MainContent />
    </BrowserRouter>
  );
}

const MainContent = () => {
  return(
    <Routes>
      <Route index path="/" element={<Login/>}/>
      <Route  path="/home" element={<Home/>}/>
    </Routes>
    )
};
