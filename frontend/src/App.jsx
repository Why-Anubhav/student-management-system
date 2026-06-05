import { useState } from "react";


function App(){
    // {"id":1,"name":"Tushar","course":"MCA"}
    const [ students,setStudent] = useState([]);

const getStudentData = async() => {
    const response = await fetch("http://localhost:8080/student");
    const data = await response.json();
    setStudent(data);
}
    return (
        <div>
            <h1> Welcome to the App!</h1>
            <button onClick={getStudentData}>
                Get Student Data
            </button>

            <ul>
                {students.map((student) =>(
                    <li key={student.id}>
                        {student.name}-{student.course}
                    </li>
                ))}
            </ul>

        </div>
    )
}

export default App;