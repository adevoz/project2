import { Component, OnInit, Input } from '@angular/core';
// import { getDefaultSettings } from 'http2';
import { Observable } from 'rxjs';
import { flattenStyles } from '@angular/platform-browser/src/dom/dom_renderer';
import { TestBedViewEngine } from '@angular/core/testing/src/test_bed';
import { Gameservice } from '../gameservice.service';
import { IGames } from '../games';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
public testing: String = 'ccc';
// @Input('parentData') public name;//template binding from parent component to child component
public game: any = [];
public gameInfo: any = [];
  constructor(private _gameService: Gameservice) { }
  public getTesting(gameName: String, platformName:String) {
    console.log("gameName: " + gameName);
    console.log("gameConsole: " + platformName);
    this.testing = gameName;
    this._gameService.test = gameName;
    console.log("GameService.Test:");
    console.log(this._gameService.test);
    this._gameService.getGameID(gameName, platformName)
    .subscribe(data => this.game = data);
    console.log(this.game);
    // this._gameService.getGameName(this.game[0].id)
    // .subscribe(data => this.gameInfo = data);
    }
  ngOnInit() {
    // this._gameService.getGame12(this._gameService.test).
    // subscribe(data => this.game = data);
    // console.log(this.game);
   }

   ngOnClick(){
     
   }

   public sleep(milliseconds) {
    var start = new Date().getTime();
    for (var i = 0; i < 1e7; i++) {
      if ((new Date().getTime() - start) > milliseconds){
        break;
      }
    }
  }


}
