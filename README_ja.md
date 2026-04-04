# WeirdAddons-Fork (日本語)

[English](README.md)

このMODは、FxMorin さんの [WeirdAddons](https://github.com/FxMorin/WeirdAddons) をベースにした非公式フォークです。  
個人で使うために改造・調整しているもので、元の作者さんとは関係ありません。

もし使いたい方がいれば、ご自由にどうぞ。  
ただし、サポートは行っておらず、使用による問題については一切責任を負いません。ご了承ください。

> 【警告】
>
> **一部の機能を有効にすると、Minecraftがクラッシュする可能性があります。**

# 機能一覧

## commandWeird
`/weird` コマンドの有効・無効を切り替えます
* 型: `String`
* デフォルト値: `ops`
* 選択肢: `ops`, `false`, `true`
* カテゴリ: `WEIRD`
* 備考:
    * `/weird` コマンドはチャンク監視やその他の機能（carpet のルールより多くの引数を必要とするもの）を使うためのコマンドです

## observerDelay
オブザーバーが反応するまでの遅延（オンになるまでの時間）を変更します
* 型: `int`
* デフォルト値: `2`
* カテゴリ: `WEIRD`, `CREATIVE`

## observerPulse
オブザーバーのパルス長（オンの状態が続く時間）を変更します
* 型: `int`
* デフォルト値: `2`
* カテゴリ: `WEIRD`, `CREATIVE`

## fastPistons
ピストンが1ティックの遅延で伸縮するようになります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## movableMovingPiston
`moving_piston`（B36）を移動可能にします。MovableBlockEntities が有効である必要があります。非常に不安定で、「できることの証明」のために作られた機能です！
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`, `EXPERIMENTAL`

## blockUpdateHell
ほぼすべての `setBlock` 呼び出しにこの数値が使われます
* 型: `int`
* デフォルト値: `-2`
* カテゴリ: `WEIRD`, `CREATIVE`, `EXPERIMENTAL`
* 備考:
    * カスタムブロック更新フラグ: -1 〜 127 | 無効にするには -2 を指定

## spongeEverything
スポンジがすべてのブロックを吸収できるようになります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## spongeLimit
スポンジが吸収できるブロックの最大数を変更します
* 型: `int`
* デフォルト値: `64`
* カテゴリ: `WEIRD`, `CREATIVE`

## spongeLava
スポンジが水ではなく溶岩を吸収するようになります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## spongeInfinite
スポンジのすべての制限を取り除きます
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`, `EXPERIMENTAL`
* 備考:
    * クラッシュを防ぐために `spongeLimit` を調整することができます。デフォルト値の場合 `spongeLimit` は無視されます！

## spongeFaster
スポンジが除去するブロックがブロックアップデートを発生させないようにします
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`
* 備考:
    * `spongeInfinite` と組み合わせたときに特に効果的です

## spongeCeption
スポンジがスポンジ自体を吸収します
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## spongeReusable
スポンジを使用しても濡れた状態にならなくなります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`
* 備考:
    * `spongeCeption` が有効な場合、この設定は機能しません

## spongeAbsorbsExplosions
スポンジが爆発によるブロック破壊を防ぎます（TNTの破壊対象ブロックリストに入っている場合）
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## enchantmentOverride
`/enchant` コマンドでバニラの最大エンチャントレベルを超えてエンチャントできるようになります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`
* 備考:
    * すべてのエンチャントがすべてのアイテムに適用できるようにもなります

## uncappedTridentSpeed
トライデントがY軸と同じ速度でX・Z軸にも移動できるようになります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`, `EXPERIMENTAL`

## executeBlockLimit
`/execute` コマンドのボリューム制限をカスタマイズできます
* 型: `int`
* デフォルト値: `32768`
* カテゴリ: `WEIRD`, `CREATIVE`
* 備考:
    * この制限の存在を知っている人はほとんどいません xD

## scaffoldingBreaking
足場ブロックの破壊ルールを変更します
* 型: `String`
* デフォルト値: `break`
* 選択肢: `break`, `float`, `gravity`
* カテゴリ: `WEIRD`, `CREATIVE`

## instantLiquidFlow
液体フローを瞬時に行います（1.16 における即時タイルティックの液体版）
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## fastLiquidFlow
すべての液体ティックが次のティックで処理されます
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## fastTileTicks
すべてのタイルティックが次のティックで処理されます
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## instantTileTick
1.16 への即時タイルティックの再実装（どちらかというと模倣に近いですが）
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## instantTileTickMechanic
即時タイルティックのゲームメカニクスです。ティッキングチャンクに囲まれたボーダーチャンク内で点灯したレッドストーンランプを移動させる必要があります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`, `crashFix`
* カテゴリ: `WEIRD`
* 備考:
    * 新しいチャンクを生成する際に `instantTileTick` がサーバーをクラッシュさせる場合もあります

## instantFall
1.16 への即時落下の再実装（何が起きても知らないぞ）
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## instantFallMechanic
即時落下のゲームメカニクスです。ボーダーチャンクに囲まれたボーダーチャンク内で点灯したレッドストーンランプを移動させると `instantFall` がオンになります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `EXPERIMENTAL`
* 備考:
    * 新しいチャンクを生成する際に `instantFall` がオフになります

## preventBreaking
すべてのプレイヤーがブロックを破壊できなくなります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`

## permaloader
冗談みたいな機能ですが、本当にすべてのチャンクがアンロードされなくなります ;)
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `true`, `false`
* カテゴリ: `WEIRD`, `CREATIVE`, `EXPERIMENTAL`

## blueSkullTesting
ウィザーが常にブルースカルを撃ち、ウィザーファームが壊れるかどうかをテストできます
* 型: `String`
* デフォルト値: `Vanilla`
* 選択肢: `Vanilla`, `Entity`, `Passive`, `All`
* カテゴリ: `WEIRD`, `CREATIVE`, `EXPERIMENTAL`

## blockTransparency
ゲーム内のすべてのブロックを透過ブロックとして扱わせます
* 型: `String`
* デフォルト値: `Vanilla`
* 選択肢: `Vanilla`, `Solid`, `Transparent`, `Inverse`
* カテゴリ: `WEIRD`, `CREATIVE`, `EXPERIMENTAL`

## worldborderNotSpecial
ワールドボーダー外でもすべてのゲームメカニクスが通常通り動作します
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `CREATIVE`, `EXPERIMENTAL`

## catOnChestBypass
ネコがチェストの上に座っていても、チェストを開けられるようになります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`

## totallyLegitElytra
エリトラが飛行によるダメージを受けなくなります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `EXPERIMENTAL`
* 備考:
    * Pixeils によるリクエスト

## breakableDragonEgg
ドラゴンの卵を採掘できるようになります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `EXPERIMENTAL`

## dragonAlwaysDropsEgg
エンダードラゴンを倒すと必ずドラゴンの卵がドロップします
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `EXPERIMENTAL`

## anvilColorFormatting
金床内で Spigot のカラーコード（フォーマット）が使えるようになります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `EXPERIMENTAL`

## shulkerCancer
シュルカーが増殖できるようになります。シュルカーを大量に隣接させてみましょう！
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `CREATIVE`, `EXPERIMENTAL`

## featherFallingPlus
フェザーフォーリングを付けたブーツを履いていると、農作物を踏み荒らさなくなります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `CREATIVE`
* 備考:
    * ElyBeatMaker によるリクエスト

## accurateEntityPositions
毎ティック、エンティティの位置パケットを送信します
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `CREATIVE`

## fallingBlockMechanic
任意のブロックを落下ブロックにできるメカニクスです
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `CREATIVE`, `EXPERIMENTAL`

## disableEntityInterpolation
クライアント側のエンティティ補間を無効にします
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `CREATIVE`, `CLIENT`

## easyWither
ウィザーが難易度「イージー」と同様の行動をするようになります
* 型: `boolean`
* デフォルト値: `false`
* 選択肢: `false`, `true`
* カテゴリ: `WEIRD`, `CREATIVE`

# チャンクの色凡例
- `#ff0000` [赤] アクセス不能チャンク
- `#000000` [黒] null チャンク
- `#555555` [ダークグレー] null ステータス
- `#aaaaaa` [グレー] ボーダーチャンク
- `#55ff55` [緑] ティッキングチャンク
- `#00aa00` [ダークグリーン] エンティティ処理チャンク
- `#aa00aa` [紫] プレイヤーがいるチャンク
- ◎ レッドストーンランプがあるチャンク
- ☻ あなたのプレイヤーがいるチャンク

# /weird コマンド
`/weird` は carpet 拡張のメインコマンドです。現在はチャンク関連の操作が使えます：

`/weird chunk <watch|set|radius|start|stop>`
- chunk
  - `watch` - チャンクの監視をオン・オフします
  - `set` - 監視するチャンクを設定します
  - `radius` - 監視するチャンクの周辺半径を設定します
  - `start` - チャンクの表示を開始します
  - `stop` - チャンクの表示を停止します

`/weird color`
- `color` - `anvilColorFormatting` で使えるカラーテーブルを表示します

