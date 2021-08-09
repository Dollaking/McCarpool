
import { useState, useEffect } from "react"
import { Navbar, Nav, NavDropdown, Container, NavLink } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { updateLength } from "../../redux/toolbar";


function NavBar() {
    const history = useHistory();
    let nav = <LoggedOut/>;
    const dispatch = useDispatch();
    const sessionLength = useSelector((state) => state.toolbar.sessionLength);


    useEffect (() => {
        console.log("USE EFFECT!");

    }, [sessionLength])

    function LogoutButton () {

        return (
            <NavLink  onClick={logoutFunction} activeClassName='active'>
                Log Out
            </NavLink>
        )
    }

    const logoutFunction = (() => {
         history.push('/');
         sessionStorage.clear();
         dispatch(updateLength());
    })

    function LoggedOut () {
        return (
            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                <Container>
                <Navbar.Brand onClick={() => {history.push('/')} }>McCarpool</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="me-auto">

                    </Nav>
                    <Nav>
                        <NavLink  onClick={() => {history.push('/login')} } activeClassName='active'>
                            Login
                        </NavLink>
                        <NavLink  onClick={() => {history.push('/registration')} } activeClassName='active'>
                            Sign Up
                        </NavLink>
                    </Nav>
                </Navbar.Collapse>
                </Container>
            </Navbar>
        )
    };

    function LoggedIn (){
        return (
            <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand onClick={() => {history.push('/')} }>McCarpool</Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link onClick={() => {history.push('/placements')} } >Placements</Nav.Link>  
                            <Nav.Link onClick={() => { history.push('/searchtrainee') }}>Trainees</Nav.Link>  
                            <Nav.Link onClick={() => {history.push('/browsequiz')} }>Quizzes</Nav.Link>
                            
                                            
                        </Nav>
                        
                        <Nav>
                            <LogoutButton/>                          
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        )
    }

    if (sessionLength == 0){
        nav = <LoggedOut/>
    
    } else {
        nav = <LoggedIn/>
    }
    


    return (
        <div>{nav}</div>
        
    )

}
export default NavBar;