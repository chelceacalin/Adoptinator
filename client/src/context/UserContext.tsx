import React, { useState, createContext, PropsWithChildren } from "react";

interface UserState {
  id: string;
  setId: React.Dispatch<React.SetStateAction<string>>;
  isLoggedIn: boolean;
  setIsLoggedIn: React.Dispatch<React.SetStateAction<boolean>>;
  username:string;
  setUsername: React.Dispatch<React.SetStateAction<string>>;
}

export const userData = createContext({} as UserState);

export function UserContext({ children }: PropsWithChildren) {
  let [isLoggedIn, setIsLoggedIn] = useState(false);
  let [id, setId] = useState("");
  let [username,setUsername]=useState("")

  return (
    <userData.Provider value={{ isLoggedIn, setIsLoggedIn, id, setId,username,setUsername }}>
      {children}
    </userData.Provider>
  );
}
