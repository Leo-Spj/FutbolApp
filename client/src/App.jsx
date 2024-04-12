
import FormFutbolista from './assets/components/FormFutbolista';
import FormPosiciones from './assets/components/FormPosiciones';
import TablaFutbolista from './assets/components/TablaFutbolistas'

function App() {
  return (
    <>
      <div className='container'>
        <h2>Leonardo Espejo</h2>
        <h4>Reto Técnico - Futbolistas</h4>
        <div className='formularios'>
          <FormFutbolista />
          <FormPosiciones />
        </div>
        <TablaFutbolista />
      </div>
    </>
  );
}

export default App;