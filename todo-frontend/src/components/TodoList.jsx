import React, { useEffect, useState } from "react";
import { getAllTodos } from "../services/TodoService";

const TodoList = () => {

  const [todos, setTodos] = useState([]);

  useEffect(() => {
    getAllTodos().then((response) => {
      setTodos(response.data);
    }).catch((error) => {
      console.log(error);
    })
  }, [])

  return (
    <div className="flex justify-center mt-4">
      <div className="flex flex-col w-11/12">
        <h1 className="flex justify-center text-xl font-bold h-12 w-11/12">
          List of Todos
        </h1>
        <div className="flex justify-center">
          <table className="w-11/12">
            <thead className="bg-gray-800">
              <tr>
                <th className="px-6 py-3 text-left text-l font-semibold text-white uppercase">
                  Title
                </th>
                <th className="px-6 py-3 text-left text-l font-semibold text-white uppercase">
                  Description
                </th>
                <th className="px-6 py-3 text-left text-l font-semibold text-white uppercase">
                  Completed
                </th>
              </tr>
            </thead>
            <tbody className="bg-white">
              {todos.map((todo, index) => (
                <tr
                  key={todo.id}
                  className={index % 2 === 0 ? "bg-slate-200" : "bg-slate-300"}
                >
                  <td className="px-6 py-4 whitespace-nowrap ">{todo.title}</td>
                  <td className="px-6 py-4 whitespace-nowrap ">
                    {todo.description}
                  </td>
                  <td className="px-6 py-4 whitespace-nowrap ">
                    {todo.completed ? "yes" : "No"}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default TodoList;
