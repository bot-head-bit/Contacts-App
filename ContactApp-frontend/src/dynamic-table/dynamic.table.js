import React ,{ useEffect, useState } from "react";
import getTableData from "./tabledata";

function DynamicTable(){

// get table column
 
const [tableData, settableData] = useState([])
const [columnData, setcolumnData] = useState([])


 useEffect(() => {
   const setData = async () => {
    const tableData = await getTableData();
    if(tableData){
     
    settableData(tableData);
    //setcolumnData(column);
    setcolumnData(["name","phone","email"]);
    }
    
  }

  setData();
   
 }, []);

 // get table heading data
 const ThData =(column)=>{
    
     return column.map((data)=>{
         return <th key={data}>{data}</th>
     })
 }

// get table row data
// const tdData =() =>{
   
//      return TableData.map((data)=>{
//        return(
//            <tr>
//                 {
//                    column.map((v)=>{
//                        return <td>{data[v]}</td>
//                    })
//                 }
//            </tr>
//        )
//      })
// }


  return (
      <table className="table">
        <thead>
         <tr>{ThData(columnData)}</tr>
        </thead>
        <tbody>
        {tableData.map((data)=>{
       return(
           <tr>
                {
                   columnData.map((v)=>{
                       return <td>{data[v]}</td>
                   })
                }
           </tr>
       )
     })}
        </tbody>
       </table>
  )
}
export default DynamicTable;