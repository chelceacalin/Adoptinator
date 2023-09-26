import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { GoogleOAuthProvider } from '@react-oauth/google';

ReactDOM.createRoot(document.getElementById('root')!).render(
    <GoogleOAuthProvider clientId='507381499144-d0953a7fqgseq4in97rpijjr52jocdsj.apps.googleusercontent.com'>
    <App />
    </GoogleOAuthProvider>
)
