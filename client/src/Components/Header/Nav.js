import React  from "react";
import Search  from "../Search/Search";
import './Nav.css';

class Nav extends React.Component{
    constructor(props){
        super(props);
    }
    render(){
        return (
            <div className = "nav">
                <div className = "wrapper">
                    <div className="logo">
                    <h1>MICROEGG</h1>
                    </div>
                    <div className="Search bar">
                    <Search/>
                    </div>
                    <div className="link">
                    <ul class="login">
                        <li><a href="/">Log in</a></li>
                        <li> <a href="/">Create an account</a></li>
                       
                    </ul>     
                </div>
                </div>
                
                <div>{this.props.children}</div>
            </div>
        );
    }
}
export default Nav;