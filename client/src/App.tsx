import "./App.css";
import Login from "./components/Login/Login";
import Home from "./components/Home/Home";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import {UserContext} from "./context/UserContext";
export default function App() {
  return (
    <UserContext>
      <BrowserRouter>
        <MainContent />
      </BrowserRouter>
    </UserContext>
  );
}

const MainContent = () => {
  return (
    <Routes>
      <Route index path="/" element={<Login />} />
      <Route path="/home" element={<Home />} />
    </Routes>
  );
};
