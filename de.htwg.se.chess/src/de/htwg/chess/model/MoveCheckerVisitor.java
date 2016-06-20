package de.htwg.chess.model;

import java.util.List;

public interface MoveCheckerVisitor {

	public List<IField> checkQueen(IField field);

	public List<IField> checkKing(IField field);

	public List<IField> checkRook(IField field);

	public List<IField> checkBishop(IField field);

	public List<IField> checkKnight(IField field);

	public List<IField> checkPawn(IField field);

}
