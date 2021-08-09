import { Container, Form, Button, Card, Alert } from "react-bootstrap";
import { useState, useEffect } from "react"
import { useHistory, useLocation } from "react-router-dom";
import { useDispatch } from "react-redux";
import { updateLength } from "../../redux/toolbar";

function Login() {
    let loginInput = "";
    let passwordInput = "";
    let history = useHistory();
    const axios = require('axios')
    const [errorMessage, setError] = useState("");
    const dispatch = useDispatch();

    const handleLoginChange = ((event) => {
        loginInput = event.target.value;
    });

    const handlePasswordChange = ((event) => {
        passwordInput = event.target.value;
    });

    const handleSubmit = ((event) => {
        event.preventDefault();
        axios
        .post('/login', {
            username: loginInput,
            password: passwordInput
        })
        .then((response) => {
            console.log(response.data);
            if (response.data.status === "success"){
                sessionStorage.setItem('username', response.data.username);
                dispatch(updateLength());
                history.push('/');
            } else {
                
                console.log("RESPONSE " + response.data.error);
                setError(response.data.error);
               
            }
            
        })
        .catch((error) => {
            console.log("Error: " + error.message);
            setError("There is an error with login!");
        })
        .finally()
    })

    return (
        <Container className="d-flex justify-content-center pt-5">

            <Card className="w-25">
                <Card.Body className="text-center">
                    <Card.Title className="pb-3">Login Form</Card.Title>
                    <Card.Text className="d-flex justify-content-center">
                        <Form onSubmit={handleSubmit}>
                            <Form.Group className="mb-2">
                                <Form.Control type="username" placeholder="Username" onChange={handleLoginChange}/>
                            </Form.Group>

                            <Form.Group className="mb-2">
                                <Form.Control type="password" placeholder="Password" onChange={handlePasswordChange}/>
                            </Form.Group>
                            <Button className="w-100" variant="primary" type="submit">
                                Login
                            </Button>
                            {errorMessage}
                            <div class="pt-3">Not a Member? <Card.Link href="#">Sign up here</Card.Link></div>
                        </Form>
                    </Card.Text>
                </Card.Body>
            </Card>

        </Container>
    )
}
export default Login;