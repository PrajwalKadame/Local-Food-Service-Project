import React, { useEffect, useState } from 'react'
import axiosInstance from './helpers/axiosInstance'
import { useParams } from 'react-router-dom'

const UserOrder = () => {

    let[userOrder,setUserOrder]=useState([])

    let [quantity,setQuantity]=useState("")

    let {id}=useParams()

    useEffect(()=>{
        let fetchData=async()=>{
            let {data}=await axiosInstance.get(`/posts/${id}`)
            setUserOrder(data)
        }
        fetchData()
    },[])

    let handleSubmit = (e) =>{
        e.preventDefault()
        if(quantity<=userOrder.pQty){
            window.localStorage.setItem("product",userOrder.product)
            window.localStorage.setItem("quantity",quantity)
            window.localStorage.setItem("price",userOrder.price)

        }else{
            alert("quantity is not available")
        }
       

    }
  return (
    <>
    <h1>{`Available Quantity ${userOrder.pQty}`}</h1>
    <form action="">
        <fieldset>
            <legend>enter the quantity</legend>
            <table>
                <tr>
                    <td>
                        <label htmlFor="quantity">Enter the Quantity</label>
                       
                    </td>
                    <td>
                    <input type="text" name="quantity" id="quantity" onChange={(e)=>{
                        setQuantity(e.target.value)
                    }} />
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                    <td>
                        <button onClick={handleSubmit}>Submit</button>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
    </>
  )
}

export default UserOrder