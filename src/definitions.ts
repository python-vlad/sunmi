import type { PluginListenerHandle } from '@capacitor/core';

export interface ScannerQRPlugin {
  addListener(eventName: 'BroadcastReceiverEvent', listenerFunc: (QRCode: { resultScan: string }) => void): PluginListenerHandle;
}
