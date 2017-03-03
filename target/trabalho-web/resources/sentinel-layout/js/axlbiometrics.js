/**
 * Created by pedro-dzs on 25/09/2015.
 */

var url = 'ws://localhost:8888//axlbiometria';
var socket;
var socketOpen = false;

function connect() {
    if (socketOpen) {
        axlLog('Websocket lazy...');
        return;
    }
    if ('WebSocket' in window) {
        socketOpen = true;
        axlLog('Websocket supported');
        socket = new WebSocket(url);
        axlLog('Connection attempted');

        socket.onerror = function (evt) {
            axlLog('Connection failure! - ' + evt.data);
            socketOpen = false;
        }

        socket.onopen = function () {
            axlLog('Connection open!');
            socketOpen = true;
            stopConnectPoll();
        }

        socket.onclose = function () {
            axlLog('Disconnecting connection');
            socketOpen = false;
        }

        socket.onmessage = function (evt) {
            axlLog('AXL message received!');
            sendBioResponse([{name: 'axlbiometrics.response', value: evt.data}]);
            reloadStatusDigital();
            PF('statusBioDialog').hide();
            PF('statusDialog').show();
        }

    } else {
        axlLog('Websocket not supported');
    }
}

function axlLog(msg) {
    console.log('AXL Biometrics - ' + msg);
}

function showMsgErrorAxlBiometrics() {
    //TODO
}
function loadBioRequest() {
    //TODO
}
function reloadStatusDigital() {
    //TODO
}

function sendBioResponse(bioresponse) {
    //TODO
}
function sendBioRequest(biorequest) {
    socket.send(biorequest);
    PF('statusBioDialog').show();
}

function stopConnectPoll() {
    if (PrimeFaces.widgets['poll_ws_connect']) {
        PF('poll_ws_connect').stop();
    }
}

function startConnectPoll() {
    showMsgErrorAxlBiometrics();
    if (PrimeFaces.widgets['poll_ws_connect'] && !socketOpen) {
        connect();
        PF('poll_ws_connect').stop();
        PF('poll_ws_connect').start();
    }
}

function solicitarBiometria() {
    if (socketOpen) {
        loadBioRequest();
        PF('statusBioDialog').show();
    } else {
        startConnectPoll();
        return false;
    }
    return true;
}


