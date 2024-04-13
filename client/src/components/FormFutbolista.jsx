import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { TextField, Button, Select, MenuItem, FormControl, InputLabel } from '@material-ui/core';

function FormFutbolista() {
    const [nombre, setNombre] = useState('');
    const [apellido, setApellido] = useState('');
    const [fechaNacimiento, setFechaNacimiento] = useState('');
    const [caracteristicas, setCaracteristicas] = useState('');
    const [posicion, setPosicion] = useState('');
    const [posiciones, setPosiciones] = useState([]);
    const [notify, setNotify] = useState({});

    useEffect(() => {
        axios.get('http://localhost:8080/posicion')
            .then(response => {
                console.log("Posiciones:", response.data);
                setPosiciones(response.data);
            })
            .catch(error => {
                console.error('error ', error);
            });
    }, []);

    const handleSubmit = (event) => {
        event.preventDefault();

        const futbolista = {
            nombre: nombre,
            apellido: apellido,
            fechaNacimiento: fechaNacimiento,
            caracteristicas: caracteristicas,
            posicion: {
                id: posicion
            }
        };

        axios.post('http://localhost:8080/futbolista', futbolista)
            .then(res => {
                
                axios.get(`http://localhost:8080/futbolista/${res.data.id}`)
                    .then(response => {
                        console.log("Futbolista creado:", response.data);
                        setNotify({ message: 'Futbolista creado', futbolista: response.data});
                    })
                    .catch(error => {
                        console.error('error', error);
                    });

            })
            .catch(error => {
                console.error('error', error);
            });
    };

    useEffect(() => {
        if (notify.message) {
            alert(notify.message + 
                '\nNombre: ' + notify.futbolista.nombre +
                '\nApellido: ' + notify.futbolista.apellido +
                '\nFecha de Nacimiento: ' + notify.futbolista.fechaNacimiento +
                '\nCaracterísticas: ' + notify.futbolista.caracteristicas +
                '\nPosición: ' + notify.futbolista.posicion.posicion);
            setNombre('');
            setApellido('');
            setFechaNacimiento('');
            setCaracteristicas('');
            setPosicion('');
        }
    }, [notify]);

    return (
        <form onSubmit={handleSubmit} className='formFutbolista'>
            <TextField required label="Nombre" value={nombre} onChange={e => setNombre(e.target.value)} />
            <TextField required label="Apellido" value={apellido} onChange={e => setApellido(e.target.value)} />
            <TextField required label="Fecha de Nacimiento" type="date" InputLabelProps={{ shrink: true }} value={fechaNacimiento} onChange={e => setFechaNacimiento(e.target.value)} />
            <TextField required label="Características" value={caracteristicas} onChange={e => setCaracteristicas(e.target.value)} />
            <FormControl required>
                <InputLabel id="posicion-label">Posición</InputLabel>
                <Select labelId="posicion-label" value={posicion} onChange={e => setPosicion(e.target.value)}>
                    {posiciones.map((posicion) => (
                        <MenuItem key={posicion.id} value={posicion.id}>{posicion.posicion}</MenuItem>
                    ))}
                </Select>
            </FormControl> 
            <Button type="submit"  variant="contained" color="primary" >Enviar</Button>
        </form>
    );
}

export default FormFutbolista;