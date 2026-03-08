import { useState } from "react"
import api from "../api/api"
import { useNavigate, Link } from "react-router-dom"
import "./Login.css"

function Login(){

 const navigate = useNavigate()

 const [email,setEmail] = useState("")
 const [password,setPassword] = useState("")

 const login = async () => {

  const res = await api.post("/auth/login",{
    email,
    password
  })

  localStorage.setItem("token",res.data.token)

  navigate("/dashboard")

 }

 return(

  <div className="login-container">

   <div className="login-card">

    <h2>Login</h2>

    <input
     placeholder="Email"
     onChange={(e)=>setEmail(e.target.value)}
    />

    <input
     type="password"
     placeholder="Password"
     onChange={(e)=>setPassword(e.target.value)}
    />

    <button onClick={login}>Login</button>

    <p className="register-link">
      Don't have an account? 
      <Link to="/register"> Register</Link>
    </p>

   </div>

  </div>

 )

}

export default Login