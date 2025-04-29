import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import StatistikSeite from './StatistikSeite.jsx';

function App() {
    return (
        <Router>
          <Routes>
                <Route path="/Christina/electric/:customer_id" element={<StatistikSeite />} />
            {/* weitere Routen */}
          </Routes>
        </Router>
    );
}

export default App;