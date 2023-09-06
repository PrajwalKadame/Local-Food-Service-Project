import React, { useEffect, useState } from 'react'
import axiosInstance from './helpers/axiosInstance'
import { useNavigate } from 'react-router-dom'

const AddProduct = () => {
let[product,setProduct]=useState("")
let[pQty,setPQty]=useState("")
let[price,setPrice]=useState("")


let [data,setData]=useState([])

let navigate=useNavigate()

//post
let handleSubmit=(e)=>{
    e.preventDefault()

    let payload={
        product,pQty,price
    }
    axiosInstance.post("/posts",payload)


}

//get

useEffect(()=>{
    let fetchData=async()=>{

        let {data}=await axiosInstance.get("/posts")
        setData(data)
    }
    fetchData()
},[])


let handleDelete=(id)=>{
    axiosInstance.delete(`/posts/${id}`)

}


  return (
    <>
    <h1>ROYAL HERMITAGE</h1>
    <h1>Hii Prajwal</h1>
    {/* <button>Add Product</button> */}
    <form action="">
        <fieldset>
            <legend>add product</legend>
        <table>
            <tr>
                <td><label htmlFor="PName">ProductName:</label></td>
                <td>
                    <input type="text" name="pName" id="pName" onChange={(e)=>{
                        setProduct(e.target.value)
                    }}/>
                </td>
            </tr>
            <tr>
                <td><label htmlFor="pQty">ProductQuantity:</label></td>
                <td>
                    <input type="text" name="pQty" id="pQty" onChange={(e)=>{
                        setPQty(e.target.value)
                    }} />
                </td>
            </tr>
            <tr>
                <td><label htmlFor="price">ProductPrice:</label></td>
                <td>
                    <input type="text" name="price" id="price" onChange={(e)=>{
                        setPrice(e.target.value)
                    }} />
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button onClick={handleSubmit}>Submit</button>
                    <button type="reset">Cancel</button>
                </td>
                
            </tr>
        </table>
        </fieldset>
    </form>
    <hr />
    <h1>Product Details</h1>
    <div>
    <table cellspacing="20px">
    <tr>
                        <th>PRODUCT</th>
                        <th>PRODUCT QUANTITY</th>
                        <th>PRODUCT PRICE</th>

                    </tr>
        {data.map((x)=>{
            return(
                <>
                
                    
                    <tr>
                        <td>{x.product}</td>
                        <td>{x.pQty}</td>
                        <td>{x.price}</td>
                        <td>
                            <button onClick={()=>{
                                navigate(`/AdminUpdate/${x.id}`)
                            }}>Update</button>
                        </td>
                        <td>
                            <button onClick={()=>{
                                handleDelete(x.id)
                            }}>Delete</button>
                        </td>
                    </tr>
                
                
                </>
            )
        })}
        </table>
    </div>
    </>
  )
}

export default AddProduct