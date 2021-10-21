import React, { Component } from 'react';
import { categories} from './data';

const CategoriesContext = React.createContext();
//provider
//consumer
class CategoriesProvider extends Component {
    state={
        parts:categories,
       
    }
    handleDetail =() => {
        console.log('hello from detail function');
    };
    addtoCart= () => {
        console.log("hello from add toc cart");
    };
    render() {
        return (
            <CategoriesContext.Provider 
            value={{
               parts:this.state,
               handleDetail:this.handleDetail,
              addtoCart:this.addtoCart
            }}>
                {this.props.children}
            </CategoriesContext.Provider>
        );
    }
}
const CategoriesConsumer  = CategoriesContext.Consumer;
export {CategoriesProvider, CategoriesConsumer};
