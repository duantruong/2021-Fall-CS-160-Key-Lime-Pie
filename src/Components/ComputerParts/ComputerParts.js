import React from 'react';
import './ComputerParts.css';

class ComputerParts extends React.Component{
    render(){
        return (
            <div className= "ComputerParts">
                <div clasName="image-container">
                    <img src={this.props.ComputerParts.imgSrc} alt=''/>
                </div>
                <h2>{this.props.ComputerParts.name}</h2>

            </div>
        );
    }
}
export default ComputerParts;