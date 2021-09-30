import React from 'react';
import './CSPartsList.css';
import ComputerParts from '../ComputerParts/ComputerParts';

class CSPartsList extends React.Component{
    render(){
        return (
            <div class="CSPartsList">
                {
                    this.props.ComputerPartsArray.map(csParts => {
                        return <ComputerParts ComputerParts= {csParts} />
                    })
                }

            </div>
        );
    }
}
export default CSPartsList;