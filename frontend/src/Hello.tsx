import { useState } from 'react';

function Hello() {
    const [message, setMessage ] = useState('');
    const [error, setError ] = useState('');
    const [loading, setLoading ] = useState(false);

    const fetchHello = async() => {
        setLoading(true);
        setError('');

        try {
            const res = await fetch('http://localhost:8081/backend-ee/api/hello');
            if (!res.ok) throw new Error('HTTP error: ${res.status}');
            const data = await res.json();
            setMessage(data.message);
        } catch(e) {
            console.error(e);
            setError('to access WildFly was failed');
        } finally {
            setLoading(false);
        }
    };
    return(
        <div style={{ padding: '2rem' }}>
            <h2>WIldFly connect</h2>
            <button onClick={fetchHello} disabled={loading}>
                {loading ? 'loading....' : 'call /api/hello' }
            </button>
            {message && <p style={{ color: 'green' }}>✅{message}</p>}
            {error && <p style={{ color: 'red' }}>❌{error}</p>}
        </div>
    );
}
export default Hello