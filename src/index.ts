import { registerPlugin } from '@capacitor/core';

import type { ScannerQRPlugin } from './definitions';

const ScannerQR = registerPlugin<ScannerQRPlugin>('ScannerQR', {
  web: () => import('./web').then(m => new m.ScannerQRWeb()),
});

export * from './definitions';
export { ScannerQR };
