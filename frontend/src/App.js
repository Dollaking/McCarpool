import {
  BrowserRouter as Router,
  NavLink,
  Route,
  Switch
} from 'react-router-dom';

import Home from './components/home/Home';
import Login from './components/accounts/Login';
import Registration from './components/accounts/Registration';
import NavBar from './components/navbar/NavBar';

import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import './axios'

function App() {
  return (
    <Router>
    <NavBar/>

      <Switch>
        <Route exact path='/' component={Home} />
        <Route exact path='/login' component={Login}/>
        <Route exact path='/registration' component={Registration}/>
      </Switch>
    </Router>

  );
}

export default App;
