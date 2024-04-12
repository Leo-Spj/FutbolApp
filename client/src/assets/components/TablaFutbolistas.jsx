import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Box } from '@material-ui/core'; 
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, Button } from '@material-ui/core';

function TablaFutbolista() {
  const [data, setData] = useState([]);
  const [lastPage, setLastPage] = useState();
  const [page, setPage] = useState(0);
  const [size, setSize] = useState(3);

  useEffect(() => {
    async function fetchData() {
      const result = await axios.get('http://localhost:8080/futbolista', {
        params: {
          page: page,
          size: size
        }
      });
      console.log(`Jugadores, pagina: ${page}, tamaño: ${size}`, result.data);
      setData(result.data.content);
      setLastPage(result.data.last);
    };
    fetchData();
  }, [page, size]);

  const nextPage = () => {
    setPage(prevPage => prevPage + 1);
  };

  const prevPage = () => {
    setPage(prevPage => Math.max(prevPage - 1, 0));
  };

  const handleDelete = () => {
    axios.delete(`futbolista/${id}`)
      .then(res => {
        console.log(res);
        console.log(res.data);

        // Redirige al usuario a la página principal después de eliminar el futbolista
        history.push('/');
      })
  };

  return (
    <TableContainer component={Paper} className='tableFutbolistas'>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Nombre</TableCell>
            <TableCell>Apellido</TableCell>
            <TableCell>Fecha de Nacimiento</TableCell>
            <TableCell>Características</TableCell>
            <TableCell>Posición</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map((row) => (
            <TableRow key={row.id}>
              <TableCell>{row.nombre}</TableCell>
              <TableCell>{row.apellido}</TableCell>
              <TableCell>{row.fechaNacimiento}</TableCell>
              <TableCell>{row.caracteristicas}</TableCell>
              <TableCell>{row.posicion.posicion}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>

      <Box display="flex" justifyContent="center" m={1} p={1}>
        <Button onClick={prevPage} disabled={page === 0}>Página anterior</Button>
        <Button onClick={nextPage} disabled={lastPage}>Siguiente página</Button>
      </Box>

    </TableContainer>
  );
};

export default TablaFutbolista;