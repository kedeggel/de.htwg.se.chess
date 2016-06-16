package de.htwg.chess.model.impl;

import java.util.List;
import de.htwg.chess.model.IChesspiece;
import de.htwg.chess.model.IField;
import de.htwg.chess.model.MoveCheckerVisitor;
import de.htwg.chess.model.impl.Team.Color;

public abstract class Chesspiece implements IChesspiece {

	protected Color color;
	protected IField field;
	protected boolean wasMoved;
	protected List<IField> possibleMoves;

	public Chesspiece(Color color, IField field) {
		this.color = color;
		this.setField(field);
		this.wasMoved = false;
	}

	@Override
	public List<IField> getPossibleMoves() {
		return possibleMoves;
	}

	@Override
	public abstract void checkPossibleMoves(MoveCheckerVisitor mc);

	@Override
	public void move(IField target) {
		for (IField posMov : possibleMoves) {
			if (target.equals(posMov)) {
				setField(target);
				wasMoved = true;
				break;
			}
		}
	}

	@Override
	public void setField(IField target) {
		IField oldPosition = this.field;
		this.field = target;
		if (target != null && this == target.getChesspiece())
			return;
		if (oldPosition != null)
			oldPosition.setChesspiece(null);
		if (target != null)
			target.setChesspiece(this);
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public IField getField() {
		return this.field;
	}

	@Override
	public boolean getWasMoved() {
		return wasMoved;
	}

	@Override
	public void setWasMoved(boolean wasMoved) {
		this.wasMoved = wasMoved;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + getColor();
	}
}
