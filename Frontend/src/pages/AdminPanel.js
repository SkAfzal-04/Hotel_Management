import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

function AdminPanel() {
  const [users, setUsers] = useState([]);
  const [rooms, setRooms] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetchUsers();
    fetchRooms();
  }, []);

  // Fetch users from API
  const fetchUsers = async () => {
    try {
      const response = await fetch('/api/users');
      const data = await response.json();
      setUsers(data);
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };

  // Fetch rooms from API
  const fetchRooms = async () => {
    try {
      const response = await fetch('/api/rooms');
      const data = await response.json();
      setRooms(data);
    } catch (error) {
      console.error('Error fetching rooms:', error);
    }
  };

  // Logout function
  const handleLogout = () => {
    // Clear session or token
    navigate('/');
  };

  return (
    <div className="min-h-screen bg-gray-100 p-4">
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-3xl font-bold">Admin Panel</h1>
        <button
          onClick={handleLogout}
          className="bg-red-500 text-white px-4 py-2 rounded-lg hover:bg-red-600"
        >
          Logout
        </button>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {/* Users Section */}
        <div className="bg-white p-6 rounded-2xl shadow-lg">
          <h2 className="text-xl font-semibold mb-4">Users</h2>
          <ul className="space-y-3">
            {users.map((user) => (
              <li
                key={user.id}
                className="p-4 bg-gray-50 rounded-lg shadow border border-gray-200"
              >
                <p className="font-medium">{user.username}</p>
                <p className="text-sm text-gray-500">{user.role}</p>
              </li>
            ))}
          </ul>
        </div>

        {/* Rooms Section */}
        <div className="bg-white p-6 rounded-2xl shadow-lg">
          <h2 className="text-xl font-semibold mb-4">Rooms</h2>
          <ul className="space-y-3">
            {rooms.map((room) => (
              <li
                key={room.id}
                className="p-4 bg-gray-50 rounded-lg shadow border border-gray-200"
              >
                <p className="font-medium">Room {room.roomNumber}</p>
                <p className="text-sm text-gray-500">
                  Status: {room.isBooked ? 'Booked' : 'Available'}
                </p>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
}

export default AdminPanel;
