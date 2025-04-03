import { useEffect, useState } from 'react';

function UserDashboard() {
  const [rooms, setRooms] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    fetchRooms();
  }, []);

  // Fetch available rooms from API
  const fetchRooms = async () => {
    try {
      setLoading(true);
      const response = await fetch('/api/rooms/available');
      const data = await response.json();
      setRooms(data);
    } catch (error) {
      console.error('Error fetching rooms:', error);
    } finally {
      setLoading(false);
    }
  };

  // Handle booking a room
  const handleBookRoom = async (roomId) => {
    try {
      const response = await fetch(`/api/bookings/book/${roomId}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ userId: 1 }), // Replace with actual logged-in user ID
      });

      if (response.ok) {
        alert('Room booked successfully!');
        fetchRooms(); // Refresh room list
      } else {
        alert('Failed to book the room.');
      }
    } catch (error) {
      console.error('Error booking room:', error);
    }
  };

  return (
    <div className="min-h-screen bg-gray-100 p-6">
      <h1 className="text-3xl font-bold mb-6 text-center">User Dashboard</h1>

      {loading ? (
        <p className="text-center text-gray-500">Loading available rooms...</p>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {rooms.length > 0 ? (
            rooms.map((room) => (
              <div key={room.id} className="bg-white p-6 rounded-2xl shadow-lg border border-gray-200">
                <h2 className="text-xl font-semibold">Room {room.roomNumber}</h2>
                <p className="text-gray-600">Status: {room.isBooked ? 'Booked' : 'Available'}</p>
                <button
                  onClick={() => handleBookRoom(room.id)}
                  className="mt-4 w-full bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600"
                  disabled={room.isBooked}
                >
                  {room.isBooked ? 'Unavailable' : 'Book Now'}
                </button>
              </div>
            ))
          ) : (
            <p className="text-center text-gray-500">No available rooms.</p>
          )}
        </div>
      )}
    </div>
  );
}

export default UserDashboard;
