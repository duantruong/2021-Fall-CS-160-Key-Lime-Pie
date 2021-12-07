import React, {useState} from "react";
import './Search.css';
import SearchIcon from '@material-ui/icons/Search';
import CloseIcon from '@material-ui/icons/Close';
import {Link} from "react-router-dom";

function Search({placeholder, data}) {
    const [filteredData, setFilteredData] = useState([]);
    const [wordEntered, setWordEntered] = useState("");
    const handleFilter = (event) => {
        const searchWord = event.target.value;
        setWordEntered(searchWord);
        const newFilter = data.data.filter((value) => {
            return value.productName.toLowerCase().includes(searchWord.toLowerCase());
        });
        if(searchWord === ""){
            setFilteredData([]);
        }
        else{
            setFilteredData(newFilter);
        }
    }
    const clearInput= ()=> {
        setFilteredData([]);
        setWordEntered("");
    }
    return(
        <div className="container ">
        <div className= "search input-group form-outline justify-content-center" >
            <div className= "searchInputs " >
                <input type = "text"  id ="form1" className="form-control" placeholder={placeholder} value={wordEntered} onChange= {handleFilter}/>
                <div className = "searchIcon">
                    <button type="button" className="btn btn-primary">
                        {filteredData.length ===0 ? <SearchIcon/> : <CloseIcon id="clearBtn" onClick={clearInput}/>}
                    </button>


                </div>
            </div>
            {filteredData.length != 0 && (
                <div className = "dataResult justify-content-center dropdown-content">
                    {filteredData.slice(0,10).map((value, key) => {
                        return (
                             <Link to={{
                                 pathname: `/ListProduct/${value.productId}`,
                                 state:`${value.category}`
                             }}>
                                 <p>
                                     {value.productName}
                                 </p>

                             </Link>

                        );
                    })}
                </div>
            )}

        </div>
        </div>
    );
}

export default Search;

