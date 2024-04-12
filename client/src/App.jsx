
import FormFutbolista from './components/FormFutbolista';
import FormPosiciones from './components/FormPosiciones';
import TablaFutbolista from './components/TablaFutbolistas'

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
      <a className='githubLink' href="https://github.com/Leo-Spj/FutbolApp">Repo GitHub</a>
    </>
  );
}

export default App;