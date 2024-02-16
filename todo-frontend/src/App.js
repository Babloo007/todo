import "./App.css";
import Footer from "./components/Footer";
import Header from "./components/Header";
import TodoList from "./components/TodoList";

function App() {
  return (
    <div className="flex flex-col min-h-screen">
      <Header />
      <div className="flex-grow">
        <TodoList />
      </div>
      <Footer />
    </div>
  );
}

export default App;
