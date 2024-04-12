import React, { useState } from 'react';
import { Button, TextField } from '@material-ui/core';
import axios from 'axios';

function FormPosiciones() {
    const [posicion, setPosicion] = useState('');

    const handleChange = (event) => {
        setPosicion(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            await axios.post('http://localhost:8080/posicion', { posicion });
            setPosicion('');
        } catch (error) {
            console.error('error al enviar dato: ', error);
        }
    };

    return (
        <form onSubmit={handleSubmit} className='formPosicion'>
            <TextField
                label="Crear Posición"
                value={posicion}
                onChange={handleChange}
            />
            <Button type="submit"  variant="contained" color="primary" >
                Crear Posición
            </Button>
        </form>
    );
}

export default FormPosiciones;