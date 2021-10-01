import React from "react";
import './Search.css';
class Search extends React.Component{
    render(){
        return (
            <form  action = "/" method="get">
                <label htmlFor="header-search">
            <span className="visually-hidden"></span>
        </label>
        <input
            type="text"
            id="header-search"
            placeholder="Search for computer parts"
            name="s" 
        />
        <button type="submit">Search</button>
            </form>
            )
    };
}
export default Search;
