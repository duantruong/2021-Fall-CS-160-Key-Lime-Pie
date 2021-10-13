import React from 'react';
import './CSPartsList.css';
import ComputerParts from '../ComputerParts/ComputerParts';

export default class CSPartsList extends React.Component{
    render(){
        return (
            <div class="CSPartsList">
                <ComputerParts/>

            </div>
        );
    }
}
