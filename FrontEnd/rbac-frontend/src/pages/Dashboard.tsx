import { jwtDecode } from "jwt-decode"
import UserCard from "../components/UserCard"
import AdminCard from "../components/AdminCard"
import "./Dashboard.css"

function Dashboard(){

 const token = localStorage.getItem("token")

 if(!token){
  return <h2 className="login-warning">Please login</h2>
 }

 const decoded:any = jwtDecode(token)

 const role = decoded.role

 return(

  <div className="dashboard-container">

   <h2 className="dashboard-title">{role} Dashboard</h2>

   <div className="dashboard-content">

     {role === "USER" && <UserCard/>}

     {role === "ADMIN" && <AdminCard/>}

   </div>

  </div>

 )

}

export default Dashboard