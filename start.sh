#
# Start script for 3D Simulation Competitions
#

NUM_PLAYERS=9
HOST=$1
PORT=3100
TEAMNAME=AST_3D
export LD_LIBRARY_PATH=$LIBS_DIR:$LD_LIBRARY_PATH

#killall -9 "$AGENT_BINARY" &> /dev/null

for ((i=1;i<=$NUM_PLAYERS;i++)); do
    echo "Running agent No. $i"
    java -jar AST_3D.jar $HOST $PORT $TEAMNAME $i /dev/null &
    sleep 2
done
