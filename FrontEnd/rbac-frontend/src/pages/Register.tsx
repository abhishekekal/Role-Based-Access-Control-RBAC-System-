import { useState } from "react"
import api from "../api/api"
import { useNavigate } from "react-router-dom"
import "./Register.css"

function Register() {

 const navigate = useNavigate()

 const [name,setName] = useState("")
 const [email,setEmail] = useState("")
 const [password,setPassword] = useState("")
 const [role,setRole] = useState("USER")

 const register = async () => {

  await api.post("/auth/register",{
    name,
    email,
    password,
    role
  })

  alert("Registered Successfully")
  navigate("/login")
 }

 return (

  <div className="register-container">

   <div className="register-card">

    <h2>Register</h2>

    <input
    placeholder="Name"
    onChange={(e)=>setName(e.target.value)}
    />

    <input
    placeholder="Email"
    onChange={(e)=>setEmail(e.target.value)}
    />

    <input
    type="password"
    placeholder="Password"
    onChange={(e)=>setPassword(e.target.value)}
    />

    <select onChange={(e)=>setRole(e.target.value)}>
     <option value="USER">USER</option>
     <option value="ADMIN">ADMIN</option>
    </select>

    <button onClick={register}>Register</button>

   </div>

  </div>

 )

}

export default Register