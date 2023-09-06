import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import axiosInstance from './helpers/axiosInstance'

const AdminUpdate = () => {
  
    let[product,setProduct]=useState("")
let[pQty,setPQty]=useState("")
let[price,setPrice]=useState("")

let {id}=useParams()




let navigate=useNavigate()

//post
let handleSubmit=(e)=>{
    e.preventDefault()

    let payload={
        product,pQty,price
    }
    axiosInstance.put(`/posts/${id}`,payload)
    navigate("/Admin")

}

//get

useEffect(()=>{
    let fetchData=async()=>{

        let {data}=await axiosInstance.get(`/posts/${id}`)
        setProduct(data.product)
        setPQty(data.pQty)
        setPrice(data.price)
    }
    fetchData()
},[])


  return (
    <>
    <h1>ROYAL HERMITAGE</h1>

    <form action="">
        <fieldset>
            <legend>update product</legend>
        <table>
            <tr>
                <td><label htmlFor="PName">ProductName:</label></td>
                <td>
                    <input value={product} type="text" name="pName" id="pName" onChange={(e)=>{
                        setProduct(e.target.value)
                    }}/>
                </td>
            </tr>
            <tr>
                <td><label htmlFor="pQty">ProductQuantity:</label></td>
                <td>
                    <input value={pQty} type="text" name="pQty" id="pQty" onChange={(e)=>{
                        setPQty(e.target.value)
                    }} />
                </td>
            </tr>
            <tr>
                <td><label htmlFor="price">ProductPrice:</label></td>
                <td>
                    <input value={price} type="text" name="price" id="price" onChange={(e)=>{
                        setPrice(e.target.value)
                    }} />
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button onClick={handleSubmit}>Update</button>
                    <button type="reset">Cancel</button>
                </td>
                
            </tr>
        </table>
        </fieldset>
    </form>
    
    </>
  )
  
}

export default AdminUpdate